import * as FileSaver from 'file-saver';

downloadPDF() {
    this.http.get("api/endpoint/address", {withCredentials: true, responseType: "blob"}).subscribe(r => {
      var blob = r;
      FileSaver.saveAs(blob, "Filename.pdf");
    });
}