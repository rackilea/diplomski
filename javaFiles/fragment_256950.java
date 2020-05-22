xx <- read.table(text='x1; y1  ; x2 ; y2
1 ; 100 ; 1  ; 150
4 ; 90  ; 2  ; 85
7 ; 85  ; 10 ; 60
10; 80  ;',sep=';',fill=TRUE,header=TRUE)

dm <- merge(xx[,1:2],xx[,3:4],by=1,all=T)
dm <- dm[!is.na(dm$x1),]
dm$y1 <- zoo::na.locf(dm$y1)
dm$y2 <- zoo::na.locf(dm$y2)
dm
  x1  y1  y2
1  1 100 150
2  2 100  85
3  4  90  85
4  7  85  85
5 10  80  60