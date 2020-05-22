const val = this.form.value;

 this.http.post('url', {
      first_name: val.first_name,
      last_name: val.last_name,
      email: val.email,
    })
      .subscribe(response => {

      });