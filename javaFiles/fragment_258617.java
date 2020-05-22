#!/bin/bash

function launch(){
    CKI_HOME='.';
    BIN_PATH="$CKI_HOME/bin";
    LIB_PATH="$CKI_HOME/lib";
    ETC_PATH="$CKI_HOME/etc";
    ITI_HOME="$BIN_PATH/itis";
    CLS_PATH="$ETC_PATH/itis/:$ITI_HOME/classes/";
    CLS_PATH="$CLS_PATH:$LIB_PATH/gpl/*:$LIB_PATH/usr/*:$ITI_HOME/lib/*:$ITI_HOME/*";

    #CMD_EXCE="java -cp $CLS_PATH com.chorke.boot.BootstrapMainApplication";
    CMD_EXCE="java -classpath $CLS_PATH com.chorke.boot.BootstrapMainApplication";
    $CMD_EXCE;
}

launch;