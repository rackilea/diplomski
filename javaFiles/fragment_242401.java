set xrange [0:2]
set yrange [0:1.8]
do for [i=0:4999] {
plot "data" u 2:1 every ::::i pt 7 ps 0.3
pause 0.1
}