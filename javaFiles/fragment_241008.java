...
} finally {
  try {
    if (br != null) br.close();
  } catch (Exception e) {
    // whatever handling
  }
}
...