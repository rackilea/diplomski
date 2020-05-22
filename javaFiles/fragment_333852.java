const functions = require('firebase-functions');
const admin = require('firebase-admin');

admin.initializeApp();

exports.deleteSwaps = functions
  .https.onRequest((req, res) => {

      const dbRef = admin.database().ref('swaps/shift_swaps').orderByChild("swapperShiftDay").equalTo(getTodayDateString());
      dbRef.once('value')
              .then(snapshot => {
                  var updates = {};
                  snapshot.forEach(childSnapshot => {
                      key = childSnapshot.key;
                      updates['swaps/shift_swaps/' + key] = null;
                  });
                  return firebase.database().ref().update(updates);
              })
              .then(() => {
                  res.send({ msg: 'Success' });
              })
              .catch(err => {
                  res.status(500).send({Error: err});
              });
  });

function getTodayDateString() {
  var d = new Date();
  var weekday = new Array(7);
  weekday[0] = "Sunday";
  weekday[1] = "Monday";
  weekday[2] = "Tuesday";
  weekday[3] = "Wednesday";
  weekday[4] = "Thursday";
  weekday[5] = "Friday";
  weekday[6] = "Saturday";

  return weekday[d.getDay()];
}