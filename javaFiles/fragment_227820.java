FeT1::usage = "Fisher's exact Test, 1 tailed. For more information:
    http://mathworld.wolfram.com/FishersExactTest.html";
FeT1[a_List, nr_Integer: 6] := Module[{},
   SumRow[array_] := Total[Transpose[array]]; 
   SumTotal[array_] := Total[Total[array]]; 
   SumColumn[array_] := Total[array]; 
   TF[list_] := Times @@ (list!); 
   N[(TF[SumColumn[a]]*TF[SumRow[a]])/(SumTotal[a]!* TF[Flatten[a]]), nr]
 ];