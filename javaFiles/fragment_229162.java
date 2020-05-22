import tensorflow as tf
import numpy as np

feature_columns = [tf.feature_column.numeric_column("x", shape=[32])]

# Build 3 layer DNN with 10, 20, 10 units respectively.
classifier = tf.estimator.DNNClassifier(feature_columns=feature_columns,
                                        hidden_units=[10, 20, 10],
                                        n_classes=4,
                                        model_dir="./model/")

# Random inputs and outputs here, probably want them from the file
train_input_fn = tf.estimator.inputs.numpy_input_fn(
    x={"x": np.random.rand(10, 32)},
    y=np.random.randint(4, size=10),
    num_epochs=None,
    shuffle=True) 
classifier.train(input_fn=train_input_fn, steps=400)

inputs = {"x" : tf.placeholder(tf.float32, shape=[None, 32])}
classifier.export_savedmodel("./saved_model", tf.estimator.export.build_raw_serving_input_receiver_fn(inputs))