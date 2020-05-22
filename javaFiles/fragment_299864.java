class DataDto {
    Data data1;
    Data data2;

    DataDto(Data data1, Data data2) {
        this.data1 = data1;
        this.data2 = data2;
    }
}

public void main() {
    Observable.zip(subject1, subject2, new BiFunction<Data, Data, DataDto>() {
        @Override
        public DataDto apply(@NonNull Data data1, @NonNull Data data2) throws Exception {
            return new DataDto(data1, data2);
        }
    }).subscribe(new Consumer<DataDto>() {
        @Override
        public void accept(@NonNull DataDto dataDto) throws Exception {
            //do something
        }
    });
}