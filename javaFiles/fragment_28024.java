function downloadFile(filename, data) {
     var link;
     link = document.createElement('a');
     link.setAttribute('href', data.replace(/#/g, '%23'));
     link.setAttribute('download', filename);
     link.style = 'visibility:hidden';
     document.body.appendChild(link);
     link.click();
     document.body.removeChild(link);
};