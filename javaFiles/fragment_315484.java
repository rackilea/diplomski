@override
  void initState() {
      super.initState();
      audioManager = AudioManager.STREAM_NOTIFICATION;
      initPlatformState();
      const fiveSec = const Duration(seconds: 15);
      timer = new Timer.periodic(fiveSec, (Timer timer) => setState(
        () {
          updateVolumes();
        }
      ));
  }

  Future<void> initPlatformState() async {
    await Volume.controlVolume(AudioManager.STREAM_NOTIFICATION);
  }

  updateVolumes() async {
    setState(() {

    });
    currentVol = await Volume.getVol;
    if (currentVol < minimumVol) {
      print('Volume needs some adjustments...');
      setVol(minimumVol);
    } else {
      print('Volume is fine!');
    }
  }

  setVol(int i) async {
    await Volume.setVol(i);
  }