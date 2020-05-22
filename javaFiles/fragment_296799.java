axios.post("http:yourAPIaddresshere", formData)
    .then((response) => {
       if(response.status === 200) {
          // storing session 
          localStorage.setItem('session', response.data.token)
          this.props.history.push('home');
        } else {
          this.showMessage('Error message', "Please check your credentials.")
        }
      } 
    });
}