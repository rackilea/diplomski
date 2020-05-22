exports.addMessage = functions.https.onCall((data, context) => {

    const uid = context.auth.uid;
    return admin.auth().getUser(uid)
      .then(userRecord => {
          const userEmail = userRecord.email;
          //....
       })
       .catch(function(error) {
           console.log('Error fetching user data:', error);
          // Send back an error to the front end
          // See https://firebase.google.com/docs/functions/callable#handle_errors
       });

});