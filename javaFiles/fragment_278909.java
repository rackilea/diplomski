from __future__ import unicode_literals

import nltk.corpus
from nltk import FreqDist
from dicttoxml import dicttoxml, xml_escape

#corpus
words = [w.decode('utf-8', errors='replace') for w in nltk.corpus.reuters.words()]
fd = FreqDist(words)
afd = {xml_escape(k):v for k,v in fd.items()}

# special key for sum
afd['__sum__']=fd.N()

xml = dicttoxml(afd)

f=open('frequencies.xml', 'w')
f.write(xml)
f.close()