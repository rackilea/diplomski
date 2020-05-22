const convMap = {};
map.forEach((val: string, key: string) => {
  convMap[key] = val;
});
this.http.post(apiBaseUrl + '/foobar', convMap, httpOptions).subscribe(
      next => console.log('next: ' + next),
      error => console.log('error: ' + error),
      () => console.log('complete')
);