android {
   applicationVariants.all{ variant->
      variant.outputs.each { output->
        if(variant.buildType.name.equals('release')){
            output.outputFile = new File('/Users/yourname/Desktop/', ’myapk.apk')
        }
    }
   }
}