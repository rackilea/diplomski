//The following code will push the alert to the "Winterhawks" and "Oil Kings" channels. 
Parse.Push.send({
  channels: [ "Winterhawks", "Oil Kings" ],
   data: {
      alert: "The Winterhawks won against the Oil Kings!"
   }
  }, {
  success: function() {
    // Push was successful
  },
  error: function(error) {
    // Handle error
  }
});