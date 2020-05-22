function csize($url) {
  $options = ['http' => [
      'method' => 'HEAD',
    ],
  ];
  $ctx = stream_context_create($options);
  $result = file_get_contents($url, false, $ctx);
  if ($result !== false) {
    foreach($http_response_header as $header) {
      if (preg_match("/Content-Length: (\d+)/i", $header, $matches)) {
        return $matches[1];
      }
    }
  }
}