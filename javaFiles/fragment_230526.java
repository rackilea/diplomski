boolean keepGoing = true;
while ((x==10000) && (keepGoing)) {
  x++;
}

void onClick(view v){
    keepGoing = false;
}