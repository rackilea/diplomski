function restoreAndStartTimer(response, initialLoad){
   var secondsToCountDown = 10;
   //Here we can use the server response to tell us if there's already
   //a timer running
   if(response.timerRunning){
      secondsToCountDown = response.secondsRemaining;
   }
   //Now kickoff the front-end timer
   function countdown(){
      //Add code here to display stuff to the screen, etc
      if(secondsToCountDown !== 0){
         secondsToCountDown--;
         setTimeout(countdown, 1000);
      }
   };
   if(initialLoad){
      if(response.timerRunning) countdown();
   } else {
      countdown();
   }
};

//Click handler, assuming you use jQuery
$('#myActivityButton').on('click', function(){ 
   $.ajax({
      url: 'https://...',
      type: 'POST',
      //Grabs the time of the click and sends it off to the server
      data: { currentTime: new Date() },
      success: function(response){
         restoreAndStartTimer(response, false);
      }
   });
});

$(function(){
   //On document ready
   //This should be wrapped as a function to avoid repetition, but for the sake of
   //expediency using this editor...
   $.ajax({
      url: 'https://...',
      type: 'POST',
      data: { currentTime: new Date() },
      //If a user had reloaded the page while a timer was running, it will get picked
      //up here, otherwise it does nothing.
      success: function(response){
         restoreAndStartTimer(response, true);
      }
   });
});