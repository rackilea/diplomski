import download from 'downloadjs';    
    .
    .
    .
    fetch(FETCH_URL, {
      method: 'GET',
      dataType: 'json',
      credentials: 'include'
    }).then(response => {
        if(response.status === 200) {
            return response.blob();
        }
      }, () => {
        // when error do something
      }
    ).then(
      // Following line helps download
      blob => download(blob, "someexcel.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    )