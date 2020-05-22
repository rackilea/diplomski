while (sc2.hasNext() && count < maxAccts) {  
  if(!sc2.hasNextInt() || !sc2.hasNextDouble()) {
            break;
  }
  acctNum[count] = sc2.nextInt();
  balance[count] = sc2.nextDouble();

}