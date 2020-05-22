// app/authorizers/application.js    
import Ember from 'ember';
    import BaseAuthorizer from 'ember-simple-auth/authorizers/base';
    const {
      isPresent,
      debug
    } = Ember;

    export default BaseAuthorizer.extend({
      authorize(sessionData, block) {
        let userToken = sessionData['accessToken'];

        if (isPresent(userToken)) {
          block('Authorization', `Bearer ${userToken}`);
        } else {
          debug('Could not find the authorization token in the session data for the jwt authorizer.');
        }
      }
    });