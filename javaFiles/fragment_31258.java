rule "IDV01 for Owner"
when
  $source: Owner($errCode : "427",
                 $id.idType == "E", $id.otherDscrp == null)
then
  _reject.getErrorCode().add($errCode.toString());
end