Intent intent = new Intent(this.getActivity(), Teste.class);
    try {
        this.finalize();
    } catch (Throwable throwable) {
        throwable.printStackTrace();
    }
    this.startActivity(intent);