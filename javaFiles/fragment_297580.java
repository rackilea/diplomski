Root;;;;;;; --> [{1,Root}] i=1
;Cat1;;;;;; --> [{1,Root},{2,Cat1}] --> i=2 --> Parent : Root
;;Sub1;;;;; --> [{1,Root},{2,Cat1},{3,Sub1}] --> i=3 --> Parent : Cat1
;;Sub2;;;;; --> [{1,Root},{2,Cat1},{3,Sub2}] --> i=3 --> Parent : Cat1
;;Sub3;;;;; --> [{1,Root},{2,Cat1},{3,Sub3}] --> i=3 --> Parent : Cat1
;Cat2;;;;;; --> [{1,Root},{2,Cat2},{3,Sub2}] --> i=2 --> Parent : Root
;;Sub4;;;;; --> [{1,Root},{2,Cat2},{3,Sub4}] --> i=3 --> Parent : Cat2
;;;SSb1;;;; --> [{1,Root},{2,Cat2},{3,Sub4},{4,SSb1}] --> i=4 --> Parent : Sub4