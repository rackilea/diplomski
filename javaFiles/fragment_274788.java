Content-Type: multipart/mixed; boundary="foo_bar_baz"
MIME-Version: 1.0
to: receiver@gmail.com
from: sender@gmail.com
subject: Subject Text

--foo_bar_baz
Content-Type: text/plain; charset="UTF-8"
MIME-Version: 1.0
Content-Transfer-Encoding: 7bit

The actual message text goes here

--foo_bar_baz
Content-Type: image/jpeg
MIME-Version: 1.0
Content-Transfer-Encoding: 
Content-Disposition: attachment; filename="example.jpg"

VG86IGZvb0BleGFtcGxlLmNvbQ0KU3ViamVjdDpJZ25vcmUNCg0KdGVzdCBtYWlsIGJvZHkNCg==

--foo_bar_baz--