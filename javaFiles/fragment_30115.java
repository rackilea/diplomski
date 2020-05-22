select assetdetail.assetname,
   sum( assetcondition.assetprice )

 from assetdetail
inner join assetcondition
   on assetcondition.indexassetdetail = assetdetail.sequenceindex

where assetcondition.fiscalyear = 2013
group by assetdetail.assetname;