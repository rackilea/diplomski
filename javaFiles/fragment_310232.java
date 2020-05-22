ngOnInit(){
    this.getRest();

    this.datareturForm = this.formBuilder.group({
      //"nomor_transaksi": ['', Validators.maxLength(10)]
      nomor_transaksi: ['', Validators.maxLength(10)],
      tgl_trans: ['', Validators.maxLength(10)],
      kd_slsman: ['', Validators.maxLength(10)],
      kd_plg: ['', Validators.maxLength(10)],
      nm_plg: ['', Validators.maxLength(10)],
      kd_wil: ['', Validators.maxLength(10)],
      nm_wil: ['', Validators.maxLength(10)],
      flagCetak: ['', Validators.maxLength(10)],
      is_Pajak: ['', Validators.maxLength(10)],
      keterangan: ['', Validators.maxLength(10)],
      username: ['', Validators.maxLength(10)],
      cetakKe: ['', Validators.maxLength(10)],
      kd_lokasi: ['', Validators.maxLength(10)],
      returDetails: this.bikinArray()
    })
  }