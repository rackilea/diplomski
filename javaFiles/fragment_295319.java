float[][] tensorData = ...;
TensorProto.Builder builder = TensorProto.newBuilder();

// Set the shape and dtype fields.
// ...

// Set the float_val field.
for (int i = 0; i < tensorData.length; ++i) {
    for (int j = 0; j < tensorData[i].length; ++j) {
        builder.addFloatVal(tensorData[i][j]);
    }
}

TensorProto tensorProto = builder.build();