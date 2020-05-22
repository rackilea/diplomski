import React, { Component } from 'react'
import { AppRegistry, Text, View } from 'react-native';
import ScannerView from './ScannerView';

class AwesomeProject extends Component {
  render() {

    return (
        <View style={styles.container}>
            <Text style={styles.hello}> Hello world </Text>
            <ScannerView style={styles.scannerview}></ScannerView>
        </View>
    );
  }
}

var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10
  },
  scannerview: {
    height: 100,
    width: 100,
  },
});

AppRegistry.registerComponent('AwesomeProject', () => AwesomeProject)