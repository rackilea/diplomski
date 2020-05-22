>> F = java.util.HashMap;
F.put(1, 123);
F.put(3, 432);
F.put(7, 31);
>> vec = cell2mat(F.keySet.toArray.cell)
vec =
     3
     7
     1
>> whos
  Name      Size            Bytes  Class                 Attributes

  F         1x1                    java.util.HashMap               
  ans       0x0                 0  double                          
  vec       3x1                24  double                          
  z         3x1                    java.lang.Object[]