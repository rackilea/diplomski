if (i%2==0) { 
    m = new Vampire("Vamp-"+i);
} else if(i%2==1) {
    m = new Ghost("Ghost-"+i);
} else if(i%3==2){
    m = new Demon("Demon-"+i);
}
else {
    m = …whatever…; // or, handle this as an error
}
monsters.add(m);