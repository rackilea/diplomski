$url = 'http://lebanonema.org/pager/html/monitor.html';

$buffer = file_get_contents($url);

$buffer = utf8_encode($buffer);

$config = [
    'doctype'    => 'omit',
    'output-xml' => 1,
];

$buffer = tidy_repair_string($buffer, $config, 'utf8');

$xml = simplexml_load_string($buffer);

$nodes = new DecoratingIterator(
    new SimpleXMLXPathIterator($xml, '//tr[count(td) > 1]'),
    'NodeParser'
);

foreach ($nodes as $index => $node) {
    echo $index, ': ', json_encode($node, JSON_PRETTY_PRINT), "\n";
}