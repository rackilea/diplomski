require 'java'
require 'lib/SentimentClassifier.jar'
java_import 'com.yourpackage.SentimentClassifier';


class Classifier 
    def self.classify
       classifier = SentimentClassifier.new
    end
end