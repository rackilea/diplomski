USE [someDB]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[sp_GetAvatarInfo] 
(
    @idList VARCHAR(MAX)
)
AS 
BEGIN 

DECLARE @idAvatarEvent INT,
        @avatarDisease INT;

SELECT @idAvatarEvent = idEventType
        FROM CCR.dbo.EventType
WHERE codeCancerGroup = 'TCC' AND eventType = 'Avatar';

--Create table to hold all SL ids that are involved in the search
IF (OBJECT_ID('tempdb.dbo.#SLList') IS NOT NULL) DROP TABLE #SLList;
CREATE TABLE #SLList
(
        idAlias INT NOT NULL IDENTITY (1,1)
        ,SLNumber VARCHar(100)
)


INSERT INTO #SLList (SLNumber)
SELECT [str]
FROM BST.dbo.fn_parseString(@idList, ',');

SELECT @avatarDisease = ATT.idAttribute
        FROM CCR.dbo.Attribute          ATT
          JOIN CCR.dbo.AttributeContainer ATC ON ATT.idAttributeContainer = ATC.idAttributeContainer
WHERE ATT.attributeName = 'avatarDiseaseGroup'
        AND ATC.containerName = 'Avatar'

  SELECT per.mrn 'PERMRN',
         per.firstName + ' ' + per.lastName 'FULLNAME',
         ali.ccNumberSeq 'CCNUMSEQ', 
         sat.aliasType 'ALIASTYPE`', 
         sl.SLNumber 'SLNUMBER', 
         sst.description 'TISSUETYPE',
         case when pt.preparationType LIKE '%Formalin%' THEN 'FFPE' ELSE pt.preparationType END 'SAMPLESUBTYPE',
         ac.choice 'SUBMITTEDDIAG'
        FROM #SLList sl
                LEFT JOIN DB1.dbo.AliquotAlias sa on sl.SLNumber = sa.alias
                LEFT JOIN DB1.dbo.AliquotAliasType sat on sa.idAliasType = sat.idAliasType
                LEFT JOIN DB1.dbo.VIEW_Aliquot2 ali on sa.idAliquot = ali.idAliquot
                LEFT JOIN DB1.dbo.Sample sam on ali.idSample = sam.id
                LEFT JOIN DB1.dbo.VIEW_SampleSubType sst on sam.codeSampleSubType = sst.codeSampleSubType
                LEFT JOIN DB1.dbo.PreparationType pt on sam.idPreparationType = pt.id
                LEFT JOIN DB1.dbo.BSTCollection col on sam.idBSTCollection = col.idBSTCollection
                LEFT JOIN DB1.dbo.BSTPatient pat on col.idBSTPatient = pat.idBSTPatient
                LEFT JOIN DB2.dbo.Person per on pat.idPerson = per.idPerson
                LEFT JOIN DB3.dbo.Patient cpat on per.idPerson = cpat.idPerson
                LEFT JOIN DB3.dbo.PatientCancerGroup pcg on cpat.idPatient = pcg.idPatient AND pcg.codeCancerGroup = 'TCC'
                LEFT JOIN DB3.dbo.MedicalEvent med on pcg.idPatient = med.idPatient AND pcg.codeCancerGroup = med.codeCancerGroup AND med.idEventType = @idAvatarEvent
                LEFT JOIN DB3.dbo.AttributeValue av on med.idAttributeValueSet = av.idAttributeValueSet AND av.idAttribute = @avatarDisease
                LEFT JOIN DB3.dbo.AttributeChoice ac on av.valueIdAttributeChoice = ac.idAttributeChoice
        ORDER BY per.mrn
END;