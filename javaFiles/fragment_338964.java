boolean pollOustanding;

while true{
  if connectAttempt(){
    pollOutstanding:=false;
    while(true){
       if readWithTimeout(2000){
          handleReceivedData(); // could be 'real' data, or poll reply from server
          pollOutstanding:=false;
       }
       else
         { if (pollOutstanding) break;
           pollOutstanding=true;
           sendPoll();
         };
    };
    closeSocket;
  };
  Sleep(10000);
};