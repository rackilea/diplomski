final ReturnValueAction[] serialNumbers=new ReturnValueAction[numberOfPieces];

for(int i=0;i<numberOfPieces;i++){
     serialNumbers[i]=new ReturnValueAction(Integer.toString(i)); 
}

context.checking(new Expectations(){{
     exactly(numberOfPieces).of (myMock).getSerialNumber();
     will(onConsecutiveCalls(serialNumbers)); 
}});