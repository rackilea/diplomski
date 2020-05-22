from bs4 import BeautifulSoup
import requests

credentials = {
    'field1':'valueForField1',
    'field2':'valueForField2'
    ...
}

s = requests.Session()

r0 = s.get('http://www.foobar.com')
r1 = s.get('http://www.foobar.com/foo')
...
r21 = s.post('http://www.foobar.com/foo/bar.do', data=credentials)
...
r23 = s.get('http://www.foobar.com/foo/bar/accountinfo')

soup = BeautifulSoup(r23.text)
product = soup.find_all('td', class_='product')

print('-------------------------------------------------------------------------------')
print()

for p in product:
    print(p)

print()
print('-------------------------------------------------------------------------------')