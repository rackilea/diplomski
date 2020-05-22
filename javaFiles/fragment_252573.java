uploadDocs($event:any){
    console.log("IMPORT")

    var files:any = $event.target.files;
    console.log(files);

    this.uploadService.uploadLibraries(files)
            .subscribe(data => this.successImport(data),
            error => this.failImport(error));
}