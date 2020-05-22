--setup emailDomain table
if OBJECT_ID('tempdb..#emailDomain') is not NULL
    drop table #emailDomain

create table #emailDomain (
    id int IDENTITY(1,1) PRIMARY KEY,
    domain varchar(50) not null
)

insert into #emailDomain
--id is automatic generated
values('aol.com')
     ,('att.net')
     ,('comcast.net')
     ,('facebook.com')
     ,('gmail.com')
     ,('gmx.com')

--setup allowedChar table
if OBJECT_ID('tempdb..#allowedChar') is not NULL
    drop table #allowedChar

create table #allowedChar(
    id int IDENTITY(1,1) PRIMARY KEY,
    aChar char(1) not null
)

insert into #allowedChar
values('a'),('b'),('c'),('d'),('e'),('f'),('g'),('h'),('i'),('j'),('k'),('l'),('m'),('n'),('o'),('p'),('q')
,('r'),('s'),('t'),('u'),('v'),('w'),('x'),('y'),('z'),('1'),('2'),('3'),('4'),('5'),('6'),('9'),('7'),('0'),('8')

--setup allowedSpecialChar table
if OBJECT_ID('tempdb..#allowedSpecialChar') is not NULL
    drop table #allowedSpecialChar

create table #allowedSpecialChar(
    id int IDENTITY(1,1) PRIMARY KEY,
    asChar char(1)
)

insert into #allowedSpecialChar
VALUES('_'),('-'),('.')

declare @countDomains as int = (select count(*) from #emailDomain)
declare @countallowedChars as int = (select count(*) from #allowedChar)
declare @countallowedSpecialChars as int = (select count(*) from #allowedSpecialChar);

if OBJECT_ID('tempdb..#rowsWithRandomCharsNrs') is not NULL
    drop table #rowsWithRandomCharsNrs;

--generate with recursion 50 rows, with an id and a random length for the e-mail address
with 
baseRowsWithEmailLength as (
    select 1 as idMail, round(RAND(CHECKSUM(NEWID())) * 60 + 1,0) as strLength
    union all
    select idMail + 1 as idMail, round(RAND(CHECKSUM(NEWID())) * 60 + 1,0) as strLength
    from baseRowsWithEmailLength 
    where idMail < 50
)
--generate with recursion a random number (indexChar) for every char in the string, which is an id to join with the table allowedChar
,rowsWithRandomCharsNrs as(
    select idMail, strLength, 1 as idchar,  round(RAND(CHECKSUM(NEWID())) * (@countallowedChars-1) +1,0) as indexChar
    from baseRowsWithEmailLength
    union all
    select idMail, strLength, idchar + 1 as idchar,  round(RAND(CHECKSUM(NEWID())) *(@countallowedChars-1) +1,0) as indexChar
    from rowsWithRandomCharsNrs
    where idchar < strLength
)


select *
into #rowsWithRandomCharsNrs
from rowsWithRandomCharsNrs


SELECT idMail  
      ,concat(left(mailRandStr, firstMailPartLength),aspc.asChar,RIGHT(mailRandStr, StrLength - firstMailPartLength), '@', ed.domain) as Mail
FROM(
    SELECT idMail
          ,strLength
          ,firstMailPartLength
          ,mailRandStr
          --generate a random number to join a random Domain and specialchar
          ,round(RAND(CHECKSUM(NEWID())) * (@countDomains-1) +1,0) as idDomain
          ,round(RAND(CHECKSUM(NEWID())) * (@countallowedSpecialChars-1) +1,0) as idSpecialChar
    FROM (
        SELECT DISTINCT
               idMail
              ,StrLength
              ,round(StrLength * 0.75,0) as firstMailPartLength 
              --concat all chars to a single string via for xml path
              ,(
                 select ''+ac.aChar
                 from #rowsWithRandomCharsNrs sub
                 join #allowedChar ac on sub.indexChar = ac.id
                 where sub.idMail = m.idMail
                 FOR XML PATH('')
              )as mailRandStr
        FROM #rowsWithRandomCharsNrs m
    ) sub
)sub
left join #emailDomain ed on sub.idDomain = ed.id
left join #allowedSpecialChar aspc on sub.idSpecialChar  = aspc.id