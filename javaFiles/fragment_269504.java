let tData = new FormData();

this.state.selectedImages.forEach((item, i) => {
  tData.append("doc[]", {
    uri: item.uri,
    type: "image/jpeg",
    name: item.filename || `filename${i}.jpg`,
  });
});

fetch(`${config.apiBase}/load/${this.props.id}/uploadconfirmation`, {
  method: "post",
  headers: {
    Accept: "application/x-www-form-urlencoded",
    Authorization: `Token ${this.props.token}`,
  },
  body: tData,
})
  .then(res => res.json())
  .then(res => {
    Alert.alert(
      "Success",
      "Uploaded Successfully!",
      [{ text: "OK", onPress: () => that.props.close() }],
      { cancelable: false }
    );
  })
  .catch(err => {
    console.error("error uploading images: ", err);
  });