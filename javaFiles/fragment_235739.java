package com.example.vision;

import com.google.auth.oauth2.GoogleCredentials;
import java.io.FileInputStream;
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.PrintStream;
import com.google.cloud.vision.v1.ImageAnnotatorSettings;
import com.google.api.gax.core.FixedCredentialsProvider;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Sample {
 public static void main(String...args) throws Exception {
  String jsonPath = "../../key.json";
  authExplicit(jsonPath);
  detectLabels(jsonPath, "../wakeupcat.jpg", System.out);
 }
 static void authExplicit(String jsonPath) throws IOException {
  GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(jsonPath))
   .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
  Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

  System.out.println("Buckets:");
  Page < Bucket > buckets = storage.list();
  for (Bucket bucket: buckets.iterateAll()) {
   System.out.println(bucket.toString());
  }
 }
 public static void detectLabels(String jsonPath, String filePath, PrintStream out) throws Exception, IOException {
  GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(jsonPath))
   .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
  List < AnnotateImageRequest > requests = new ArrayList < > ();

  ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

  Image img = Image.newBuilder().setContent(imgBytes).build();
  Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
  AnnotateImageRequest request =
   AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
  requests.add(request);
//Setting the credentials:
  ImageAnnotatorSettings imageAnnotatorSettings = ImageAnnotatorSettings.newBuilder()
   .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
   .build();
  try (ImageAnnotatorClient client = ImageAnnotatorClient.create(imageAnnotatorSettings)) {
   BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
   List < AnnotateImageResponse > responses = response.getResponsesList();

   for (AnnotateImageResponse res: responses) {
    if (res.hasError()) {
     out.printf("Error: %s\n", res.getError().getMessage());
     return;
    }

    // For full list of available annotations, see http://g.co/cloud/vision/docs
    for (EntityAnnotation annotation: res.getLabelAnnotationsList()) {
     annotation.getAllFields().forEach((k, v) -> out.printf("%s : %s\n", k, v.toString()));
    }
   }
  }
 }
}