rule "IDV01"
  @description("IF Individual Identifier = E, THEN Other Description is required. ")
when
  $id: IDVerify(idType == "E", otherDscrp == null)
then
end

rule "IDV01 for Owner" extends "IVD01"
when
  $source: Owner($errCode : "427", id == $id)
then
  _reject.getErrorCode().add($errCode.toString());
end