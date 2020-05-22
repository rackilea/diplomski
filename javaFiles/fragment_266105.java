postgres=> select * from usp_sel_article_initialdata_new1();
 usp_sel_article_initialdata_new1
----------------------------------
 <unnamed portal 1>
 <unnamed portal 2>
(2 rows)

postgres=> fetch all from "<unnamed portal 1>";
 ?column?
----------
        1
(1 row)

postgres=> fetch all from "<unnamed portal 2>";
 ?column?
----------
        2
(1 row)

postgres=>