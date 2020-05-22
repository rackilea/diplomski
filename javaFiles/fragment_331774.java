send_queue.append({'to': REGISTRATION_ID,
               'message_id': random_id(),
               "notification" : {
                  "body" : "Hello from Server! What is going on? Seems to work!!!",
                  "title" : "Hello from Server!",
                  "icon" : "@drawable/ic_school_white_48dp",
                  "sound": "default",
                  "color": "#03A9F4",
                  "click_action": "OPEN_MAIN_ACTIVITY"
                },
               'data': { 'message': "Hello" }})