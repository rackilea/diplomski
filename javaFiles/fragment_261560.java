constructor(private restApiService: RestApiService /** **/) { }

onSubmit() {
  const formModel = this.loginForm.value;
  this.restApiService.postCredentials(formModel.email, formModel.password);
    .subscribe(.....)
}