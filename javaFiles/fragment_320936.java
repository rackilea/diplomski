check the size of list
th:if="${#lists.size(exampleList)} &gt; 0">
//String equals check
th:if="${megaDetails.megaType } eq 'SFFIXMEGA' or ${megaDetails.megaType } eq 
     'MFFIXMEGA' "
Aggregate the varible in list
#aggregates.sum(commitAllocationResponse.allocatedMegas.![feeDollars])