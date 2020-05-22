auto androidContext = QtAndroid::androidContext();

QAndroidJniObject dir = QAndroidJniObject::fromString(QString(""));

QAndroidJniObject path = androidContext.callObjectMethod("getExternalFilesDir",
                                                         "(Ljava/lang/String;)Ljava/io/File;",
                                                         dir.object());

qInfo() << "Path: " + path.toString();