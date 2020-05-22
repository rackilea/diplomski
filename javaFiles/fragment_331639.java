create table Category (              
  targetId int,
  ...);        

create table TranslationTargets (
  id int primary key
);      

create table TranslatableText (              
  targetId int not null,              
  lang enum ('NO','EN','FR'),              
  text mediumtext,              
  primary key(targetId, lang));