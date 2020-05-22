setTimeout(() => {
    this.btSerial.write(uint8Array)
      .then(dataz => {
        console.log("WRITE SUCCESS", dataz);
      });
  }, 100 + n *100)