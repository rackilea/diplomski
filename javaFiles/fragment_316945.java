//The number of solutions from the fifth step

countDp(5) = countDp(4)+countDp(3)+countDp(2);

//Number of solutions from the fourth step

countDP(4) = countDp(3)+countDp(2)+countDp(1);

//Number of solutions from the third step

countDp(3) = countDp(2)+countDp(1)+countDp(0);
//Number of solutions from the second step
countDp(2) = countDp(1)+countDp(0)+countDp(-1);
//Number of solutions from the first step
countDp(1) = countDp(0) + countDp(-1)+countDp(-2);
//Finally, base case
countDp(0) = 1;

countDp(-1)= 0;
countDp(-2)= 0;
countDp(1) = 1+0+0 = 1;
countDp(2) = 1+1+0 = 2;  //Dynamic programming: did not have to resolve for countDp(1), instead looked up the value in map[1]
countDp(3) = 2+1+1 = 4;  //Dynamic programming, did not have to solve for countDp(1), countDp(2), instead looked up value in map[1] and map[2]
countDp(4) = 4+2+1=7 //Dynamic programming, did not have to solve for CountDp(3),CountDp(2), CountDp(1), just looked them up in map[3],map[2],map[1]
countDp(5)=  2+4+7=13 //Dynamic programming, just used map[4]+map[3]+map[2]