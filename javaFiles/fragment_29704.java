SELECT * FROM user_types;

ut_id    ut_code    ut_desc
=====    =======    =======
1        DECO       decoration
2        ENTR       entertainment
3        CATR       catering
4        SECR       security


SELECT * FROM user_type_details WHERE ut_id = 2;

ut_det_id   ut_id    ut_det_code   ut_det_desc
=========   =====    ===========   ===========
7           2        D.J.          dj
8           2        SNGR          singer
9           2        DNCR          dancer
10          2        GTRS          guitarist