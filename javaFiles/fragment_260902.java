firebase.auth().onIdTokenChanged((user: firebase.User) => {
      console.log("onIdTokenChanged");
      if(user && user.uid) {
        user.getIdToken(false)
        .then((data: any) => {
          console.log("data: ", data);
          this.idToken = data;
        });
      }      
    });